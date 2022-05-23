from bs4 import BeautifulSoup

soup = BeautifulSoup("<html>a web page</html>", 'html.parser')

# Tag object
tag = soup.html
print(type(tag))
print(tag)
# tag name
print(tag.name)
# the tag name can be set

tag = BeautifulSoup('<b id="boldest">bold</b>', 'html.parser').b
print(tag['id'])
# or
print(tag.attrs)

tag['id'] = 'verybold'
tag['another-attribute'] = 1
print(tag)
# <b another-attribute="1" id="verybold"></b>

del tag['id']
del tag['another-attribute']
print(tag)



# NavigableString object
soup = BeautifulSoup('<b class="boldest">Extremely bold</b>', 'html.parser')
tag = soup.b
tag.string
# 'Extremely bold'
type(tag.string)
# <class 'bs4.element.NavigableString'>
print(str(tag.string))



# BeautifulSoup object



#Comments and other special strings
markup = "<b><!--Hey, buddy. Want to buy a used parser?--></b>"
soup = BeautifulSoup(markup, 'html.parser')
comment = soup.b.string
print(type(comment))