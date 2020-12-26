<template>
  <div>
    <div class="background_container">
    <div class="content_container">
      <div class="style_welcome_head__container">
        <div class="style_welcome_head__style">
          <h1 class="style_welcome_head__title style_welcome_head__title_margin">MovieBlog</h1>
          <h2 class="style_welcome_head__text">The best resource about world of cinema</h2>
        </div>
      </div>
      <div class="style_random_button__container">
        <button class="myButton_Home" v-on:click="getRandomMovie">Random Movie</button>
      </div>
      <div class="style_top_5__container">
        <h2 class="style_welcome_head__style style_welcome_head__text">Top 5 movies</h2>
        <div class="style_top_5__poster_container">
            <div class="styles_posterColumn__width" v-for="item in items">
              <router-link :to="{path: '/film/' + item.id}">
                <img class="film-poster styles_pic__size styles_pic__back image"
                     :src="getPoster(item.id)"/>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>
</template>

<script>
import api from './backend-api'

export default {
  name: 'Home',
  data() {
    return {
      items: [],
      posters: []
    }
  },
  created() {
    api.getMovieWithHigherRating()
        .then(response => {
          this.items = response.data
          for (let i = 0; i < this.items.length; i++){
            api.getMoviePoster(this.items[i].id)
                .then(response => {
                  this.posters.push({id:this.items[i].id, img: 'data:' + response.headers['content-type'] + ';base64,' + response.data})})
            }
          })
  },
  methods: {
    getRandomMovie: function () {
      api.getRandomMovieId().then((response => {
        window.location.href  = '/film/' + response.data.toString()
      }))
    },
    getPoster: function (id){
      for (let i = 0; i < this.posters.length; i++)
        if (this.posters[i].id === id)
          return this.posters[i].img
      return ''
    }
  }
}
</script>
