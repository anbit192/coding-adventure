class Employee:
    def __init__(self, eid, name, year, basic_salary):
        self.eid = eid
        self.name = name
        self.year = year
        self.basic_salary = basic_salary

    def get_salary(self):
        return self.basic_salary


class Manager(Employee):
    def get_salary(self):
        return 0


class DataScientist(Employee):

    def __init__(self, eid, name, year, basic_salary, project):
        super().__init__(eid, name, year, basic_salary)
        self.project = project

    def get_salary(self):
        return self.basic_salary


class Developer(DataScientist):

    def get_salary(self):
        return self.basic_salary


def LoadEmployeesFromFiles(file_name):
    file = open(file_name, "r")
    lines = file.readlines()
    employees = []

    i = 0
    while (i < len(lines)):
        id = lines[i]
        name = lines[i + 1]
        year = lines[i + 2]
        salary = lines[i + 3]
        if ("DV" in id ):
            prjs = lines[i + 4]
            dv = Developer(id, name, year, salary, prjs)
            employees.append(dv)
            i += 4
        elif ("DS" in id):
            prjs = lines[i + 4]
            ds = DataScientist(id, name, year, salary, prjs)
            employees.append(ds)
            i += 4
        else:
            i += 3

    print(employees)
        




