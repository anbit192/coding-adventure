from tkinter import *
from tkinter import ttk #creates an instance of the Tk class, which initializes Tk and creates its associated Tcl interpreter

root = Tk() #root window

#creates a frame widget, which in this case will contain a label and a button we’ll create next. The frame is fit inside the root window.
frame = ttk.Frame(root, padding=10)

frame.grid() #create grid

ttk.Label(frame, text = "Hello World!").grid(column = 1, row = 0) #Create label contain string
ttk.Button(frame, text = "Quit!", command = root.destroy).grid(column = 2, row = 5) #create button

root.mainloop() #display everything, respond to user input
