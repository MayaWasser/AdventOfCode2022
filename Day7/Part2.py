input = open("input.txt", "r");
lines = input.readlines()

def addDirectory(directories, path):
    if not path in directories.keys():
        directories[path] = []
    return directories

def findSize(paths, dir):
    size = 0
    for file in dir:
        if (file.isdigit()):
            size += int(file)
        else:
            size += findSize(paths, paths[file] )
    return size

def findSizes(paths):
    directorySizes = {}
    for directory in paths.keys():
        directorySizes[directory] = findSize(paths, directories[directory] )
    return directorySizes

directories = {}
currentPath = ""
for line in lines:
    parts = line.split()
    if (line.startswith("$ cd")):
        if (parts[-1] == "/"):
            currentPath = "/"
        elif (parts[-1] == ".."):
            currentPath = "/".join( currentPath.split("/")[:-2] ) + "/"
        else:
            currentPath += parts[-1] + "/"
        addDirectory(directories, currentPath)

    if (parts[0].isdigit()):
        directories[currentPath].append( parts[0] )

    if (parts[0] == "dir"):
        directories[currentPath].append( currentPath + parts[1] + "/")

directorySizes = findSizes(directories)
unused = 70000000 - directorySizes["/"]
sizeToDelete = directorySizes["/"]
for size in directorySizes.values():
    if (unused + size >= 30000000):
        if (size < sizeToDelete):
            sizeToDelete = size

print(sizeToDelete)

input.close()
