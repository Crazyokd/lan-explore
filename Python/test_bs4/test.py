from bs4 import BeautifulSoup

with open("reminder.html") as fp:
    soup = BeautifulSoup(fp, 'html.parser')

# print(len(soup.body))
# print(type(soup.table))
# print(str(soup.table))
# print(len(soup.table))

html = soup.select("div.reminderbody > div.reminderwrap > ul")[0]
print(type(html))
# for child in html:
    # print(child)
    # print("================================")
# print(html)
with open("table_w.html", 'w', encoding='utf-8') as f:
    f.write(str(html))