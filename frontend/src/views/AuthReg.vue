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
            <input type="text" id="inputEmail" v-model="login" class="form-control" style="margin-left: 3px" placeholder="Login" required autofocus>
          </div>
          <div class="input">
            <label for="inputPassword">Password</label>
            <input type="password" id="inputPassword" v-model="password" class="form-control" style="margin-left: 3px"  placeholder="Password" required>
          </div>
        </div>
        <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="myButton" type="submit" v-on:click="signIn_button_clicked">Sign in</button>
        <button class="myButton" type="button" v-on:click="create_acc_button_clicked">Create account</button>
        </div>
      <div v-else>
        <div class="input_box">
          <div class="input">
            <label for="inputEmail">Login</label>
            <input type="text" id="inputNewEmail" class="form-control" style="margin-left: 3px" placeholder="Login" required autofocus>
          </div>
          <div class="input">
            <label for="inputPassword">Password</label>
            <input type="password" id="inputNewPassword" class="form-control" style="margin-left: 3px"  placeholder="Password" required>
          </div>
          <div class="input">
            <label for="inputPassword">Repeat Password</label>
            <input type="password" id="inputNewPasswordRepeat" class="form-control" style="margin-left: 3px"  placeholder="Password" required>
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
import user from "../components/user/user";
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
      //some ajax
    },
    signIn_button_clicked(){
      if (this.validate()){
        const result = {
          login: 'user',
          accessToken: 'a123'
        }
        user.auth(result)
      }
    },
    validate(){
      this.errors = {}
      if (this.login.trim().length === 0) {
        this.errors.email = 'Заполните Email.'
      }
      if (this.password.trim().length === 0) {
        this.errors.password = 'Заполните Пароль.'
      }
      return Object.keys(this.errors).length === 0
    }
  },
  data(){
    return {
      login: '',
      password: '',
      errors: {},
      current_state: 1
    }
  }
}
</script>