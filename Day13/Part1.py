def createList(line):
    line = line[1:len(line)-1]
    result = []
    i = 0;
    while i < len(line):
        curr = line[i]
        if curr == "[":
            end = findLeftBracket( line[i:] )
            result.append( createList(line[i:end+i+1]) )
            i = end+i
        elif (curr.isdigit()):
            result.append( int(curr) )
        i += 1
    return result

def findLeftBracket(line):
    countRight = 0
    countLeft = 0
    for i in range( len(line) ):
        letter = line[i]
        if letter == '[':
            countRight += 1
        if letter == ']':
            countLeft += 1
        if countRight == countLeft:
            return i
    return -10000000

# returns true if they are in the right order, with list1 first
def compareLists(list1, list2):
    smaller = min(len(list1), len(list2))
    for i in range(smaller):
        term1 = list1[i]
        term2 = list2[i]
        if type(term1) is int and type(term2) is int:
            if term1 != term2:
                return term1 < term2
        elif type(term1) is list or type(term2) is list:
            if type(term1) is int:
                term1 = [term1]
            if type(term2) is int:
                term2 = [term2]
            return compareLists(term1, term2)
    return len(list1) <= len(list2)

input = open("input.txt", "r")
lines = input.readlines()


sum = 0
index = 1
lineNum = 0
while (lineNum < len(lines)):
    packet1 = createList(lines[lineNum].strip())
    packet2 = createList(lines[lineNum+1].strip())
    print(compareLists(packet1, packet2))
    if compareLists(packet1, packet2):
        sum += index
    index += 1
    lineNum += 3

print(sum)

input.close();
