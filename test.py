from passlib.context import CryptContext

pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")

hashed_pwd = pwd_context.hash("minhandz")

print(pwd_context.verify("minhandz1", hashed_pwd))





