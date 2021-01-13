<template>
  <div class="styles_bg styles_page">
  <div class="myFont">
  <div>
    <h1 class="welcome">Welcome to MovieBlog</h1>
  </div>
  <form class="form-signin">
      <div v-if="current_state === 1">
        <div class="input_box">
          <div class="input">
            <label for="inputEmail">Login</label>
            <input type="text" id="inputEmail" v-model="login" class="form-control" style="margin-left: 3px"
                   placeholder="Login" required autofocus>
          </div>
          <div class="input">
            <label for="inputPassword">Password</label>
            <input type="password" id="inputPassword" v-model="password" class="form-control" style="margin-left: 3px"
                   placeholder="Password" required>
          </div>
        </div>
        <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="myButton" type="button" id="sign_in_button" v-on:click="signIn_button_clicked">Sign in</button>
        <button class="myButton" type="button" id="create_account_button" v-on:click="create_acc_button_clicked">Create account</button>
        </div>
      <div v-else>
        <div class="input_box">
          <div class="input">
            <label for="inputEmail">Login</label>
            <input type="text" id="inputNewEmail" @change="checkUsername" v-model="registrationUsername" class="form-control" style="margin-left: 3px" placeholder="Login" required autofocus>
            <p v-if="isUsernameExist" style="font-size: 12pt; margin-top: 2px; margin-bottom: 2px">Пользователь уже существует</p>
          </div>
          <div class="input">
            <label for="inputPassword">Password</label>
            <input type="password" id="inputNewPassword" v-model="registrationPassword" class="form-control" style="margin-left: 3px"  placeholder="Password" required>
          </div>
          <div class="input">
            <label for="inputPassword">Repeat Password</label>
            <input type="password" id="inputNewPasswordRepeat" v-model="registrationPasswordRepeat" class="form-control" style="margin-left: 3px"  placeholder="Password" required>
          </div>
        </div>
        <button class="myButton" type="submit" v-on:click="back_button_clicked">Back</button>
        <button class="myButton" type="button" v-on:click="registration_button_clicked">Registration</button>
      </div>
  </form>
  </div>
  </div>
</template>

<script>
import api from "../views/backend-api"

export default {
  name: "AuthReg",
  methods: {
    create_acc_button_clicked(){
      this.current_state = 2
    },
    back_button_clicked(){
      this.current_state = 1
    },
    registration_button_clicked(){
      if (this.validate_registration()){
        api.sendUserRegistrationData(this.registrationUsername, this.registrationPassword)
        .then((response) => {
          if (response.data)
            api.authorizationUser(this.registrationUsername, this.registrationPassword)
          .then((auth_response) =>{
            localStorage.setItem('access-token', auth_response.data['access_token'])
            localStorage.setItem('username', this.registrationUsername)
            window.location.href = '/'
          })
          .catch(() => console.log('Registration error'))
        })
      }
    },
    signIn_button_clicked(){
      if (this.validate()){
        console.log('Auth started')
        api.authorizationUser(this.login, this.password).then((response) => {
          localStorage.setItem('access-token', response.data['access_token'])
          localStorage.setItem('username', this.login)
          window.location.href = '/'
        }
        ).catch(() => console.log('No access'))
      }
    },
    validate(){
      this.errors = {}
      if (this.login.trim().length === 0)
        this.errors.email = 'Заполните Email.'
      if (this.password.trim().length === 0)
        this.errors.password = 'Заполните Пароль.'
      console.log(this.errors)
      return Object.keys(this.errors).length === 0
    },
    validate_registration(){
      this.errors = {}
      if (this.registrationUsername.trim().length === 0)
        this.errors.registrationUsername = 'Заполните имя пользователя'
      if (this.registrationPassword.trim().length === 0 || this.registrationPasswordRepeat.trim().length === 0)
        this.errors.registrationPassword = 'Заполните пароль'
      if (this.registrationPassword !== this.registrationPasswordRepeat)
        this.errors.registrationPasswordRepeat = 'Пароли не совпадают'
      if (this.isUsernameExist)
        this.errors.isUsernameExist = 'Имя пользователя уже существует'
      return Object.keys(this.errors).length === 0
    },
    async checkUsername(){
      console.log(this.registrationUsername)
      await api.ajaxUsernameNotExists(this.registrationUsername).then(response => {
        this.isUsernameExist = response.data;
      })
    }
  },
  data(){
    return {
      login: '',
      password: '',
      errors: {},
      current_state: 1,
      registrationUsername: '',
      isUsernameExist: false,
      registrationPassword: '',
      registrationPasswordRepeat: ''
    }
  },
}
</script>