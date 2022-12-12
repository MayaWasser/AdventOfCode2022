def applyOperation(old, operation):
    if operation[2:] == "old":
        num = old
    else:
        num = int(operation[2:])
    if operation[0] == "*":
        return old * num
    if operation[0] == "+":
        return old + num

input = open("input.txt", "r")
lines = input.readlines();

worryLevels = [ ]
operations = [ ]
tests = [ ]
ifTrue = [ ]
ifFalse = [ ]
count = [ ]

for lineNum in range(len(lines)):
    line = lines[lineNum].strip()
    if lineNum % 7 == 1:
        items = line[16:].split(",")
        worryLevels.append( [ int(item.strip()) for item in items] )
        count.append(0)
    if lineNum % 7 == 2:
        operations.append( line[21:] )
    if lineNum % 7 == 3:
        tests.append( int(line[19:]) )
    if lineNum % 7 == 4:
        ifTrue.append( int(line[25:]) )
    if lineNum % 7 == 5:
        ifFalse.append( int(line[26:]) )

manageWorry = 1
for i in tests:
    manageWorry *= i

def turn(monkey):
    for item in worryLevels[monkey]:
        count[monkey] += 1
        item = applyOperation(item, operations[monkey]) % manageWorry
        if item % tests[monkey] == 0:
            worryLevels[ ifTrue[monkey] ].append(item)
        else:
            worryLevels[ ifFalse[monkey] ].append(item)
    worryLevels[monkey] = []

def round():
    for i in range( len(count) ):
        turn(i)

for i in range(10000):
    round()

topMonkey = max(count)
count.remove(topMonkey)
secondMonkey = max(count)
ans = topMonkey * secondMonkey
print(ans)

input.close()
