from django import forms

from .models import Usuario


class AltaUsuario(forms.ModelForm):
	class Meta:
		model = Usuario
		fields = ('username', 'email', 'nombre', 'apellido', 'password')
'''
class UserLoginForm(forms.Form):
	username = forms.CharField()
	password = forms.CharField(widget= forms.PasswordInput)

	def clean(self, *args, **kwargs):
		username = self.cleaned_data.get('username')
		password = self.cleaned_data.get('password')


		if username and password:
			user = authenticate(username = username, password=password)
			if not user:
				raise forms.ValidationError('Este usuario no existe')
			if not user.check_password(password):
				raise forms.ValidationError('Contraseña incorrecta')
			if not user.is_active:
				raise forms.ValidationError('Este usuario no está activo')

		return super(UserLoginForm, self).clean(*args, **kwargs)


class UserRegisterForm(forms.ModelForm):
	email = forms.EmailField(label='Correo electrónico')
	email2 = forms.EmailField(label='Confirmar correo')

	passwrod = forms.CharField(widget= forms.PasswordInput)

	class Meta:
		model = User
		fields = [
				'username',
				'email',
				'email2',
				'password'
		]

	def clean_email(self):
		email = self.cleaned_data.get('email')
		email2 = self.cleaned_data.get('email2')

		if email != email2:
			raise forms.ValidationError("Los correos electrónicos no coinciden")

		email_qs = User.objects.filter(email=email)
		if email_qs.exists():
			raise forms.ValidationError("Este correo ya está en uso")
		return email

'''
