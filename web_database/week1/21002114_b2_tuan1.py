def subjects(id):
    subj_name = id[0:3]

    return subj_name == "MAT"


print(subjects("MAT23"))
print(subjects("GEO23"))