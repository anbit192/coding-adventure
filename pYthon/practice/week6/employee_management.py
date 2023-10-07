class Employee:
    def __init__(self, eid, name, year, basic_salary):
        self.eid = eid
        self.name = name
        self.year = int(year)
        self.basic_salary = float(basic_salary)

    def getSalary(self):
        return self.basic_salary


class Manager(Employee):
    def getSalary(self):
        return self.basic_salary + self.basic_salary / 4


class DataScientist(Employee):

    def __init__(self, eid, name, year, basic_salary, project):
        super().__init__(eid, name, year, basic_salary)
        self.project = int(project)

    def getSalary(self):
        return self.basic_salary + self.basic_salary * 0.2 + self.project * 1500    


class Developer(DataScientist):

    def getSalary(self):
        return self.basic_salary + self.project * 1000


def loadEmploysFromFile(file_name):
    file = open(file_name, "r")

    employees = []

    while (True):
        
        id = file.readline()
        if not id:
            break
        name = file.readline()
        year = file.readline()
        salary = file.readline()

        if ("DV" in id ):
            prjs = file.readline()
            dv = Developer(id, name, year, salary, prjs)
            employees.append(dv)
        elif ("DS" in id):
            prjs = file.readline()
            ds = DataScientist(id, name, year, salary, prjs)
            employees.append(ds)
        elif ("M" in id):
            manager = Manager(id, name, year, salary)
            employees.append(manager)
        elif ("E" in id):
            e = Employee(id, name, year, salary)
            employees.append(e)

    return employees
        



