import pandas as pd

def students_and_examinations(students: pd.DataFrame, subjects: pd.DataFrame, examinations: pd.DataFrame) -> pd.DataFrame:
    
    a = list(students['student_id'])
    b = list(students['student_name'])
    dic = dict(zip(a, b))
    c = list(subjects['subject_name'])
    d = list(examinations['student_id'])
    e = list(examinations['subject_name'])
    dic1 = list(zip(d, e))

    track = []
    counter = []
    names = []
    sub = []
    idi = []

    
    for i in range(len(e)):
        if (d[i], e[i]) not in track:
            idi.append(d[i])
            names.append(dic[d[i]])
            sub.append(e[i])
            counter.append(dic1.count((d[i], e[i])))
            track.append((d[i], e[i]))

    
    for j in range(len(a)):
        for j1 in range(len(c)):
            if (a[j], c[j1]) not in dic1:
                dic1.append((a[j], c[j1]))
                idi.append(a[j])
                names.append(dic[a[j]])
                counter.append(0)
                sub.append(c[j1])

    
    result = pd.DataFrame({
        "student_id": idi,
        "student_name": names,
        "subject_name": sub,
        "attended_exams": counter
    })

    
    result.sort_values(by=["student_id", "subject_name"], inplace=True)

    return result