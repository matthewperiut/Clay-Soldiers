import os

folder_name = input("folder?")
os.mkdir(folder_name)
soldier = input("soldier?")
dye_name = "minecraft:" + input("dye?")

for i in range(1,9):
    f = open(folder_name + "/" + str(i) + ".json", "w")
    f.write(    '{\n' + \
                '  "type": "minecraft:crafting_shapeless",\n' + \
                '  "ingredients": [\n')
    for j in range(i):
        f.write('    {\n' + \
                '        "tag": "clay:soldiers"\n' + \
                '    },\n')
    f.write(    '    {\n' + \
                '      "item": "' + dye_name + '"\n' + \
                '    }\n' + \
                '  ],\n' + \
                '  "result":\n' + \
                '  {\n' + \
                '    "count": ' + str(i) + ',\n' + \
                '    "id": "clay:soldier/' + soldier + '"\n' + \
                '  }\n' + \
                '}')
    f.close()

