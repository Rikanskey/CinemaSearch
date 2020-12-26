<template>
  <div class="styles_root__main_container__profile">
    <div class="styles_profileContainer__main_props">
      <div class="styles_containerProfile_props">
        <div class="styles_container__props_margin">
          <div class="profileInfoWrapLeft">
            <div class="styles_avatar__user_box">
              <img :src="avatar" style="height: 100%; width: 100%">
            </div>
            <div v-if="isThisActualUser()" style="margin-left: 20px; border: groove; height: 20px; width: 90px">
              <label for="file" class="btn">Update avatar</label>
              <input id="file" type="file" @change="uploadImage" style="visibility: hidden">
            </div>
            </div>
          <div class="profileInfoWrapRight">
            <h2 class="styles_font__nickname">{{user.username}}</h2>
          </div>
        </div>
      </div>
      <div class="styles_history_votes">
          <h2 class="styles_font__nickname">History of votes</h2>
          <div class="styles_profile_film_list">
            <div class="styles_profile_top_list">
              <div class="styles_profile_list_num">№</div>
              <div class="styles_profile_list_name">Movie</div>
              <div class="styles_profile_list_mark">User mark</div>
            </div>
              <div v-for="movie in user.movies" :key="movie.id" class="styles_item">
                <div class="styles_profile_list_num">{{user.movies.indexOf(movie)+1}}</div>
                <router-link :to="/film/ + movie.movie.id">
                  <div class="styles_profile_list_name">{{movie.movie.name}}</div>
                </router-link>
                <div class="styles_profile_list_mark">{{movie.rating}}</div>
            </div>
          </div>
      </div>
    </div>

  </div>
</template>

<script>
import api from '../views/backend-api'

export default {
name: "Profile",
  created() {
    api.getUser(this.$route.params.id).then(response =>{
      console.log(response.data)
      this.user = response.data
      this.user.movies = response.data.movie
    })
    api.getUserAvatar(this.$route.params.id).then(response => {
      this.avatar = 'data:' + response.headers['content-type'] + ';base64,' + response.data
    })
  },
  data(){
  return{
    avatar: '',
    user: {
        username: '',
        movies: [],
        selectedFile: null
    }
    }
  },
  methods: {
    isThisActualUser(){
      return this.user.username === localStorage.getItem('username')
    },
    uploadImage(event){
      console.log(event)
      this.selectedFile = event.target.files[0]
      let formData = new FormData()
      formData.append('avatar', this.selectedFile)
      console.log(this.selectedFile)
      if (this.selectedFile.name.split('.')[1] === 'jpg')
        api.postUserAvatar(this.$route.params.id, formData)
        .then(() => api.getUserAvatar(this.$route.params.id)
          .then(response => this.avatar = 'data:' + response.headers['content-type'] + ';base64,' + response.data))
    }
  }
}
</script>