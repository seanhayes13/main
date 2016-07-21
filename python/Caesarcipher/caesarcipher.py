#Caesar Cipher program

def mainMenu():
    print("Select an action:")
    print("1 - Encrypt a message using one key")
    print("2 - Encrypt a message using two keys")
    print("3 - Decrypt a message using one known key")
    print("4 - Decrypt a message using two known keys")
    print("5 - Decrypt a message with one or two unknown keys")
    print("6 - Exit")
    
def mainProgram(option):
    if option == '1':
        getOneKeyEncryptInput()
    if option == '2':
        getTwoKeyEncryptInput()
    if option == '3':
        getOneKeyDecryptInput()
    if option == '4':
        getTwoKeyDecryptInput()
    if option == '5':
        getUnknownKeyDecryptInput()
    if option == '6':
        exit()
    
def getOneKeyEncryptInput():
    key = 0
    message = input("Enter the phrase to encrypt: ")
    while key < 1 or key > 26:
        key = int(input("Enter the key value (1-26): "))
    encryptedMessage = oneKeyEncrypt(message, key)
    print("The ecrypted message is: ",encryptedMessage)

def oneKeyEncrypt(message, key):
    encr = ''
    alpha = "abcdefghijklmnopqrstuvwxyz"
    lowerMsg = message.lower()
    shiftedAlpha = shiftAlpha(key)
    for a in lowerMsg:
        currChar = lowerMsg[lowerMsg.index(a)]
        if(currChar.isalpha() == False):
            encr += currChar
        else:
            encr += shiftedAlpha[alpha.index(currChar)]
    return encr
    
def getTwoKeyEncryptInput():
    key1 = 0
    key2 = 0
    message = input("Enter the phrase to encrypt: ")
    while key1 < 1 or key1 > 26:
        key1 = int(input("Enter the first key value (1-26): "))
    while key2 < 1 or key2 > 26:
        key2 = int(input("Enter the second key value (1-26): "))
    encryptedMessage = twoKeyEncrypt(message, key1, key2)
    print("The ecrypted message is: ",encryptedMessage)
    
def twoKeyEncrypt(message, key1, key2):
    encr = ''
    ctr = 0
    alpha = "abcdefghijklmnopqrstuvwxyz"
    lowerMsg = message.lower()  
    shiftedAlpha1 = shiftAlpha(key1)
    shiftedAlpha2 = shiftAlpha(key2)
    for c in lowerMsg:
        currChar = lowerMsg[lowerMsg.index(c)]
        if(currChar.isalpha() == False):
            encr += currChar
        if ctr%2==0:
            encr += shiftedAlpha1[alpha.index(currChar)]
        if ctr%2==1:
            encr += shiftedAlpha2[alpha.index(currChar)]
        ctr+=1
    return encr
    
def getOneKeyDecryptInput():
    key = 0
    message = input("Enter the phrase to decrypt: ")
    while key < 1 or key > 26:
        key = int(input("Enter the key value (1-26): "))
    decryptedMessage = oneKKeyDecrypt(message, key)
    print("The ecrypted message is: ",decryptedMessage)
    
def oneKKeyDecrypt(message, key):
    decr=''
    alpha = "abcdefghijklmnopqrstuvwxyz"
    lowerMsg = message.lower()
    shiftedAlpha = shiftAlpha(26-key)
    for c in lowerMsg:
        currChar = lowerMsg[lowerMsg.index(c)]
        if(currChar.isalpha() == False):
            decr += currChar
        else:
            decr += shiftedAlpha[alpha.index(currChar)]
    return decr
    
def getTwoKeyDecryptInput():
    key1 = 0
    key2 = 0
    message = input("Enter the phrase to decrypt: ")
    while key1 < 1 or key1 > 26:
        key1 = int(input("Enter the first key value (1-26): "))
    while key2 < 1 or key2 > 26:
        key2 = int(input("Enter the second key value (1-26): "))
    decryptedMessage = twoKKeyDecrypt(message, key1, key2)
    print("The ecrypted message is: ",decryptedMessage)
    
def twoKKeyDecrypt(message, key1, key2):
    decr=''
    ctr = 0
    alpha = "abcdefghijklmnopqrstuvwxyz"
    lowerMsg = message.lower()
    shiftedAlpha1 = shiftAlpha(26-key1)
    shiftedAlpha2 = shiftAlpha(26-key2)
    for c in lowerMsg:
        currChar = lowerMsg[lowerMsg.index(c)]
        if(currChar.isalpha() == False):
            decr += currChar
        if ctr%2==0:
            decr += shiftedAlpha1[alpha.index(currChar)]
        if ctr%2==1:
            decr += shiftedAlpha2[alpha.index(currChar)]
        ctr+=1
    return decr
    
def getUnknownKeyDecryptInput():
    message = input("Enter the phrase to decrypt: ")
    number = input("How many keys were used to encrypt, 1 or 2? ")
    if number == '1':
        decryptedMessage = oneUKeyDecrypt(message)
        print(decryptedMessage)
    elif number == '2':
        twoUKeyDecrypt(message)
    else:
        print("Invalid number, for now...")
    
def oneUKeyDecrypt(message):
    alpha = "abcdefghijklmnopqrstuvwxyz"
    lowerMsg = message.lower()
    bigrams = ["bk", "fq", "jc", "jt", "mj", "qh", "qx", "vj", "wz", "zh", "bq", "fv", "jd", "jv", "mq", "qj", "qy", "vk", "xb", "zj", "bx", "fx", "jf", "jw", "mx", "qk", "qz", "vm", "xg", "zn", "cb", "fz", "jg", "jx", "mz", "ql", "sx", "vn", "xj", "zq", "cf", "gq", "jh", "jy", "pq", "qm", "sz", "vp", "xk", "zr", "cg", "gv", "jk", "jz", "pv", "qn", "tq", "vq", "xv", "zs", "cj", "gx", "jl", "kq", "px", "qo", "tx", "vt", "xz", "zx", "cp", "hk", "jm", "kv", "qb", "qp", "vb", "vw", "yq", "cv", "hv", "jn", "kx", "qc", "qr", "vc", "vx", "yv", "cw", "hx", "jp", "kz", "qd", "qs", "vd", "vz", "yz", "cx", "hz", "jq", "lq", "qe", "qt", "vf", "wq", "zb", "dx", "iy", "jr", "lx", "qf", "qv", "vg", "wv", "zc", "fk", "jb", "js", "mg", "qg", "qw", "vh", "wx", "zg"]
    for k1 in range (26):
        decr =''
        shiftedAlpha = shiftAlpha(26-k1)
        for c in lowerMsg:
            currChar = lowerMsg[lowerMsg.index(c)]
            if(currChar.isalpha() == False):
                decr += currChar
            else:
                decr += shiftedAlpha[alpha.index(currChar)]
        bgCheck = 0
        for bg in bigrams:
            if bg in decr:
                bgCheck+=1
        if bgCheck == 0:
            return decr
    
def twoUKeyDecrypt():
    print("Coming soon")
    
def shiftAlpha(key):
    alpha="abcdefghijklmnopqrstuvwxyz"
    shiftedAlpha = ''
    shiftedAlpha = alpha[key:] + alpha[0:key]
    return shiftedAlpha
    
    
if __name__=="__main__":
    option = 999
    while option != -1:
        mainMenu()
        option = input("Make a selection: ")
        mainProgram(option)
