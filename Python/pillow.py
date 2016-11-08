from PIL import Image

im = Image.open('smile.jpg')

print(im.format, im.size, im.mode)

im.thumbnail((512, 342))
im.save('thumb.jpg', 'jpg')
