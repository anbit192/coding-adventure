library(ISLR)
Hitters
names(Hitters)

sum(is.na(Hitters$Salary))

Hitters = na.omit(Hitters)
sum(is.na(Hitters$Salary))

library(leaps)

reg = regsubsets(Salary ~., data = Hitters, nvmax = 19)
summary = summary(reg)
which.max(summary$rsq)

par(mfrow = c(2, 2))

plot(summary$rss, xlab = "Number of variables", ylab = "RSS", type = "l")
plot(summary$rsq, type = "l")
plot(summary$bic, type = "l")
plot(summary$adjr2, type = "l")

rss_max = which.min(summary$rss)
rss_max
points(rss_max, summary$rss[rss_max], col = "red", cex = 2, pch = 20)
