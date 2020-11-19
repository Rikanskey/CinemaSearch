<template>
  <div id="app">
    <header>
      <nav class="styles_header__props styles_headerContainer__color" style="--header-height:108px">
          <div class="styles_header__inner_props">
            <div class="styles_header_width_height">
              <div class="styles_position__logo_Header">
                <router-link class="styles_font__logo_Header" v-bind:to="{name: 'Home'}">MovieBlog</router-link>
                <router-link v-if="!user.isAuth() && $router.currentRoute.path !== '/auth'" class="styles_font__signIn_Header styles__signIn_Button" v-bind:to="{name: 'AuthReg'}">Sign In</router-link>
                <div v-else-if="user.isAuth()" class="styles_font__signIn_Header styles__signIn_Button">
                  <div class="styles_font__signIn_Header styles__profile_logout_Button" v-on:click="user.logout()">Logout</div>
                  <router-link class="styles_font__signIn_Header styles__profile_logout_Button" to="/profile/{user.id}">Profile</router-link>
                </div>
              </div>
            </div>
          </div>
      </nav>
    </header>

    <main role="main">
      <router-view/>
    </main>

    <footer class="container styles_footer__props styles_headerContainer__color">
      <div class="styles_footer__font">
        <p class="float-right"><a href="#">Back to top</a></p>
        <p>&copy; 2020 BSTU. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </div>
    </footer>
  </div>
</template>

<script>
import User from "./components/user/user";

export default {
  name: 'app',
  data(){
    return{
      user: User
    };
  }
}
</script>
