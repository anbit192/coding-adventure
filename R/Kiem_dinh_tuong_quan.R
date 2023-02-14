
# Doc file csv
data = read.csv("C:\\Users\\ADMIN\\Desktop\\Book1.csv", header=T)
Auto

# gan vao auto
attach(Auto)

# He so tuong quan
cor(mpg, weight) 

# kiem dinh su tuong quan

## TOM TAT SO LIEU

cor.test(mpg, weight)

## du lieu: mpg va weight
## Test thong ke t = -29.645
## Bac tu do: df = 390
## p_value < 2.2^(e^-16)
## Doi thuyet H1: He so tuong quan khac 0
## Khoang tin cay 95% cho HSTQ la (-0.86, ........., -0.799)
## HSTQ mau: r = -0.8322442


## BAI TOAN KIEM DINH

## Goi S la HSTQ giua mpg va weight
## Btoan: H0 : S = 0
##        H1 : S != 0
## alpha = 1 - Khoang tin cay = 1 - 95% = 5%
## p - value < 2.2^e^-16 < alpha
## => Bac bo H0
## KL: Voi muc y nghia 5%, co the noi mpg va weight co tuong quan



 # mo hinh

lm(mpg ~ weight)
# mpg = 46.2165 - 0.0076 * weight


lm(weight ~ mpg)
# weight = 5101.11 - 90.57 * mpg


summary(lm(mpg ~ weight))


