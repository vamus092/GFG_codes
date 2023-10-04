//LAGRANGE'S INTERPOLATION
#include<stdio.h>
#include<conio.h>
int main()
{	int i,j,n;
float x[100],y[100],m,o,sum=0.0,p;
	printf("ENTER THE LIMIT:\t");
	scanf("%d",&n);
	printf("ENTER THE ELEMENTS:\n ");
	for(i=0;i<n;i++)
	{
		scanf("%f%f",&x[i],&y[i]);	
	}
	printf("ENTER THE INTERPOLATION POINT:\t");
	scanf("%f",&m);
	
	for(i=0;i<n;i++)
	{
		p=1;
		for(j=0;j<n;j++)
		{
			if(i!=j)
			{
				p*=((m-x[j])/(x[i]-x[j]));
			}
		}
		sum=sum+p*y[i];
	}
	printf("\nTHE SUM IS:%f",sum);
	return 0;
	}
	
