days = {"s", "b", "d", "df"}
print(days[4])


a = {x = 10, y = 20}
print(a.x)
print(a.y)


polyline = {color = "blue",
	thickness = 2,
	npoints = 4,
	{x = 0, y = 0},
	{x = -10, y = 0}
}

print(polyline[2].x)
print(polyline[1].y)


opnames = {["-"] = "sub", ["+"] = "add"}
s = "-"
print(opnames[s])
