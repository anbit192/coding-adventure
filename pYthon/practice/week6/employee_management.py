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
        return 0


class Developer(DataScientist):

    def get_salary(self):
        return 0


def LoadEmployeesFromFiles(file_name):
    employees = []
