from .base import * 

DEBUG = True

ALLOWED_HOSTS=[]


DATABASES = {
    'default': {
        'ENGINE': 'sql_server.pyodbc',
        'NAME': 'Alaula',
        'HOST': 'IDEA-PC\SQLEXPRESS', 
        'OPTIONS': {
        			'driver': 'SQL Server Native Client 11.0'
        }
    }, 
}
