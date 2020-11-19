<template>
  <div class="styles_root__main_container__profile">
    <div class="styles_profileContainer__main_props">
      <div class="styles_containerProfile_props">
        <div class="styles_container__props_margin">
          <div class="profileInfoWrapLeft">
            <div class="styles_avatar__user_box">
              <img v-bind:src="user.avatar" alt="">
            </div>
          </div>
          <div class="profileInfoWrapRight">
            <h2 class="styles_font__nickname">{{user.name}}</h2>
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
                <router-link to="/film/{movie.id}">
                  <div class="styles_profile_list_name">{{movie.name}}</div>
                </router-link>
                <div class="styles_profile_list_mark">{{movie.user_mark}}</div>
            </div>
          </div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
name: "Profile",
  data(){
  return{
    user: {
        name: 'user',
        avatar: '',
        movies: [
          {
            id: 1,
            name: 'TENET',
            user_mark: 9
          },
          {
            id: 2,
            name: 'Pulp fiction',
            user_mark: 2
          }
        ]
    }
    }
  }
}
</script>

<style>
/*.styles_root__main_container {*/
/*  z-index: 1;*/
/*  display: flex;*/
/*  -webkit-box-orient: vertical;*/
/*  -webkit-box-direction: normal;*/
/*  flex-direction: column;*/
/*  min-height: 100vh;*/
/*  background: #f4f4f4;*/
/*}*/

/*.styles_contentContainer__main_props {*/
/*  z-index: 2;*/
/*  -webkit-box-flex: 1;*/
/*  flex: 1 0 auto;*/
/*  background: #fff;*/
/*  width: 1280px;*/
/*  margin: auto;*/
/*}*/

/*.styles_container__props_margin {*/
/*  display: flex;*/
/*  box-sizing: border-box;*/
/*  margin-top: 20px;*/
/*  margin-right: -10px;*/
/*  margin-left: 20px;*/
/*}*/

/*.profileInfoWrapLeft {*/
/*  margin: 0;*/
/*  padding: 0 0 30px 0;*/
/*  width: 180px;*/
/*  float: left;*/
/*}*/

/*.styles_avatar__user_box{*/
/*  border: 5px solid #FFFFFF;*/
/*  box-shadow: 0 1px 2px #999999;*/
/*  width: 120px;*/
/*  height: 190px;*/
/*  overflow: hidden;*/
/*  margin-bottom: 10px;*/
/*}*/

/*.profileInfoWrapRight {*/
/*  float: left;*/
/*  width: 645px;*/
/*}*/

/*.styles_font__nickname{*/
/*  font-family: 'Georgia', serif;*/
/*  color: #333333;*/
/*  font-size: 23px;*/
/*  font-weight: bold;*/
/*  font-style: italic;*/
/*  padding-left: 0;*/
/*  width: 350px;*/
/*}*/


/*!* history votes table *!*/
/*.styles_history_votes{*/
/*  margin-top: 30px;*/
/*}*/

/*.styles_profile_film_list{*/
/*  width: 100%;*/
/*  color: #333;*/
/*}*/

/*.styles_profile_top_list{*/
/*  margin-top: 5px;*/
/*  height: 50px;*/
/*  flex-direction: column;*/
/*  background: #ec9b08;*/
/*  color: #fff;*/
/*  font-family: Arial,Tahoma,Verdana,sans-serif;*/
/*  padding: 2px 0 3px 0;*/
/*  font-size: 25pt;*/
/*}*/

/*.styles_profile_list_num {*/
/*  width: 300px;*/
/*  float: left;*/
/*  padding: 7px 0 0 5px;*/
/*}*/

/*.styles_profile_list_name{*/
/*  width: 600px;*/
/*  float: left;*/
/*  padding-top: 7px;*/
/*}*/

/*.styles_profile_list_mark{*/
/*  float: left;*/
/*  width: 200px;*/
/*  padding-top: 7px;*/
/*}*/

/*.styles_item{*/
/*  padding-top: 5px;*/
/*  padding-bottom: 5px;*/
/*  height: 45px;*/
/*  font-size: 20pt;*/
/*  color: black;*/
/*  font-family: Arial,Tahoma,Verdana,sans-serif;*/
/*  font-style: oblique;*/
/*  -webkit-text-stroke: 2px rgb(0, 0, 0);*/
/*  border-bottom: 1px solid;*/
/*}*/
</style>