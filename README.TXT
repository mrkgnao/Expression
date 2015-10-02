Expression Evaluator v3.0
------------------------------------------------------------------
Can evaluate any (simple) math expression!
Supports functions and constants too.

Supported operators
------------------------------------------------------------------
Operator with syntax			Purpose
-------------------------------------------------------------------
a+b                       Adds a to b. 
a-b                       Subtracts b form a. 
a*b                       Multiplies a and b. 
a/b                       Divides a by b. 
a%b                       Returns a modulo b. 
a^b                       Returns a to the power b. 
aEb                       Shorthand for a*10^b. 
a!                        Returns the factorial of a. 


Supported functions
-------------------------------------------------------------------
Function with syntax			Purpose
-------------------------------------------------------------------
sqrt(x)                   Returns the square root of a number. 
cbrt(x)                   Returns the cube root of a number. 
rand()                    Returns a random number between 0 and 1. 
randInt(a,b)              Returns a random integer between a and b. 
exp(x)                    Returns e to the power x. 
ln(x)                     Returns the logarithm of x to the base e. 
log(x)                    Returns the logarithm of x to the base 10. 
logab(a,b)                Returns the logarithm of a to the base b. 
sin(x)                    Returns the sine of x. 
cos(x)                    Returns the cosine of x. 
tan(x)                    Returns the tangent of x. 
asin(x)                   Returns the inverse sine of x. 
acos(x)                   Returns the inverse cosine of x. 
atan(x)                   Returns the inverse tangent of x. 
sinh(x)                   Returns the hyperbolic sine of x. 
cosh(x)                   Returns the hyperbolic cosine of x. 
tanh(x)                   Returns the hyperbolic tangent of x. 
asinh(x)                  Returns the inverse hyperbolic sine of x. 
acosh(x)                  Returns the inverse hyperbolic cosine of x. 
atanh(x)                  Returns the inverse hyperbolic tangent of x. 
min(a,b,....z)            Returns the minimum of a,b,...z. 
max(a,b,....z)            Returns the maximum of a,b,...z 
abs(x)                    Retuns the absolute value of x. 
sum(a,b,....z)            Returns a+b+....+z. 
prod(a,b,....z)           Returns a*b*....*z. 
floor(x)                  Returns the greatest integer less than or equal to x. 
ceil(x)                   Retuns the least integer greater than or equal to x. 
sign(x)                   Retuns +1 if x>0, -1 if x<0, 0 if x=0. 
round(x)                  Returns the rounded value of x. 
fact(x)                   Returns the factorial of x. 
perm(n,r)                 Retuns n!/(n-r)! 
comb(n,r)                 Returns n!/r!/(n-r)!

Constants
-------------------------------------------------------------------
Constants are stored in the file constants.txt in the same directory as the program.
If the file does not exist when the program is started, a blank one will be created.
To set a constant to a value, type <constant>==<value>. Ex: m==2 or pi==3.
To delete a constant, set its value to 0.
The ans constant stores the previous answer.
The following constants are available with their corresponding values.

Constant	Value
-------------------------------------------------------------------
ans		0
pi		3.1415926535
e		2.7182818284
phi		1.61803398875
y		0.5772156649
h		1.054571800E-34
c		299792458
N		6.0221409E23
R		8.3144621
k		1.38064852E-23
G		6.67E-11

The order of operations are as follows:
1.Brackets, 2.Functions, 3.Exponents, 4.Multiplication/Division 5.Addition/Subtraction