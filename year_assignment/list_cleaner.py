file=open("input.txt", "r")
lines=file.readlines()
file.close()

for i in range (0,len(lines)):
    lines[i]=lines[i].rstrip()+'\n'
    print(lines[i])

file=open("names_and_passwords.txt", "w")
file.writelines(lines)
file.close()