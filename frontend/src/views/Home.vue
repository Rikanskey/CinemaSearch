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
        <button class="myButton_Home">Random Movie</button>
      </div>
      <div class="style_top_5__container">
        <h2 class="style_welcome_head__style style_welcome_head__text">Top 5 movies</h2>
        <div class="style_top_5__poster_container">
            <div class="styles_posterColumn__width" v-for="item in items" :key=item.id>
              <router-link to="/film/{item.id}">
                <img class="film-poster styles_pic__size styles_pic__back image"
                     v-bind:src="item.poster" alt="">
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>
</template>

<script>
export default {
  name: 'Home',
  data() {
    return {
      items: [
        {
          id: 1,
          poster: 'https://images-na.ssl-images-amazon.com/images/I/71W2aEcrxxL._AC_SL1334_.jpg'
        },
        {
          id: 2,
          poster: 'https://st.kp.yandex.net/im/poster/4/3/4/kinopoisk.ru-The-Godfather-434475.jpg'
        },
        {
          id: 3,
          poster: 'https://st.kp.yandex.net/im/poster/2/5/8/kinopoisk.ru-Pulp-Fiction-2589679.jpg'
        },
        {
          id: 4,
          poster: 'https://st.kp.yandex.net/im/poster/8/1/7/kinopoisk.ru-The-Lord-of-the-Rings_3A-The-Return-of-the-King-817079.jpg'
        },
        {
          id: 5,
          poster: 'https://st.kp.yandex.net/im/poster/2/4/4/kinopoisk.ru-Lock_2C-Stock-and-Two-Smoking-Barrels-2443231.jpg'
        }
      ]
    }
  }
}
</script>
