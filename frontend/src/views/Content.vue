<template>
  <div class="styles_root__main_container">
    <div class="styles_contentContainer__main_props">
      <div class="styles_сontainer__props">
        <div class="styles_container__props_margin">
          <div class="styles_posterColumn__width styles_column__el_position">
            <div class="styles_poster__position">
              <div class="styles_poster__pic_padding">
                <a>
                  <img class="film-poster styles_pic__size styles_pic__back image"
                       v-bind:src="movie.poster" alt>
                </a>
              </div>
            </div>
          </div>
          <div class="styles_column__el_position styles_info_container__pos">
            <div class="styles_container_info__padding">
              <div class="styles_container__props_margin">
                <div class="styles_title__pos">
                  <h1 class="styles_title__margin styles_title__font styles_title__color" itemprop="name">{{movie.name}}</h1>
                </div>
              </div>
              <div class="styles_container__props_margin">
                <div class="styles_column__el_position styles_info__pos">
                  <h3 class="styles_title_info__pos styles_title_info__font_size styles_title_info__font_style styles_title__color">
                    About Movie
                  </h3>
                  <div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Year</div>
                      <div class="styles_value__props">{{movie.year}}</div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Country</div>
                      <div v-for="country in movie.country" :key="country.id">
                        <div v-if="movie.country.indexOf(country) !== movie.country.length-1">
                          <div class="styles_value__props">{{country.name}},</div>
                        </div>
                        <div v-else>
                          <div class="styles_value__props">{{country.name}}</div>
                        </div>
                      </div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Genre</div>
                      <div v-for="genre in movie.genre" :key="genre.id">
                        <div v-if="movie.genre.indexOf(genre) !== movie.genre.length-1">
                          <div class="styles_value__props">{{genre.name}},</div>
                        </div>
                        <div v-else>
                          <div class="styles_value__props">{{genre.name}}</div>
                        </div>
                      </div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Director</div>
                      <div v-for="director in movie.director" :key="director.id">
                        <div v-if="movie.director.indexOf(director) !== movie.director.length-1">
                          <div class="styles_value__props">{{director.name}},</div>
                        </div>
                        <div v-else>
                          <div class="styles_value__props">{{director.name}}</div>
                        </div>
                      </div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Writer</div>
                      <div v-for="writer in movie.writer" :key="writer.id">
                        <div v-if="movie.writer.indexOf(writer) !== movie.writer.length-1">
                          <div class="styles_value__props">{{writer.name}}, </div>
                        </div>
                        <div v-else>
                          <div class="styles_value__props">{{writer.name}}</div>
                        </div>
                      </div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Producer</div>
                      <div v-for="producer in movie.producer" :key="producer.id">
                        <div v-if="movie.producer.indexOf(producer) !== movie.producer.length-1">
                          <div class="styles_value__props">{{producer.name}},</div>
                        </div>
                        <div v-else>
                          <div class="styles_value__props">{{producer.name}}</div>
                        </div>
                      </div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Operator</div>
                      <div v-for="operator in movie.operator" :key="operator.id">
                        <div v-if="movie.operator.indexOf(operator) !== movie.operator.length-1">
                          <div class="styles_value__props">{{operator.name}},</div>
                        </div>
                        <div v-else>
                          <div class="styles_value__props">{{operator.name}}</div>
                        </div>
                      </div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Compositor</div>
                      <div v-for="compositor in movie.compositor" :key="compositor.id">
                        <div v-if="movie.compositor.indexOf(compositor) !== movie.compositor.length-1">
                          <div class="styles_value__props">{{compositor.name}},</div>
                        </div>
                        <div v-else>
                          <div class="styles_value__props">{{compositor.name}}</div>
                        </div>
                      </div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Budget</div>
                      <div class="styles_value__props">{{movie.budget}} $</div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Box office</div>
                      <div class="styles_value__props">{{ movie.box_office }} $</div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Release</div>
                      <div class="styles_value__props">{{movie.release}}</div>
                    </div>
                    <div class="styles_rowInformation__color styles_rowInformation__position">
                      <div class="styles_title__props">Duration</div>
                      <div class="styles_value__props">{{movie.duration}}</div>
                    </div>
                  </div>
                </div>
                <div class="styles_column__el_position styles_actors__pos">
                  <div class="styles_actors__pad ">
                    <h3 class="styles_actors_title__margin styles_title_info__font_style styles_title__color">
                      Starring
                    </h3>
                    <ul class="styles_actor_list__margin">
                          <li class="styles_actor__props" v-bind:key="star.id" v-for="star in movie.actor">{{star.name}}</li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>


      </div>
      <div class="styles_container__back styles_container__disp">
        <div class="styles_сontainer__props">
          <h3 class="styles_actors_title__margin styles_title_info__font_style styles_title__color">Synopsis</h3>
          <div class="styles_synopsis__font">
            <p>{{movie.synopsis}}</p>
          </div>
        </div>
      </div>
      <div class="styles_raiting__marg styles_сontainer__props">
        <h3 class="styles_actors_title__margin styles_title_info__font_style styles_rootDark__QT0qE">Raiting</h3>
        <form class="styles_form__disp " id="star_list">
          <label class="styles_radio__star_container styles_root__star_container"  v-bind:key="index" v-for="index in 10" v-bind:data-value=index>
            <input type="radio" class="styles_input__disp" name="star" v-bind:value="index" v-on:click="send_mark(index)">
            <span class="styles_iconContainer__pos" @mouseover="over_star(index)" @mouseleave="out_star()">
              <span v-if="index <= movie.rating && actual_mark === 0" class="styles_icon__marg styles_defaultIcon__star styles_baseIcon__star styles_filledIcon__star">
                <full_star></full_star>
              </span>
              <span v-else-if="index <= actual_mark" class="styles_icon__marg styles_defaultIcon__star styles_baseIcon__star styles_hoveredIcon__star">
                <hovered_star></hovered_star>
              </span>
              <span v-else class="styles_icon__marg styles_defaultIcon__star styles_baseIcon__star styles_defaultIcon__star">
                <empty_star></empty_star>
              </span>
            </span>
          </label>
        </form>
        <div v-if="user.isAuth() && movie.user_mark !== 0">Ваша оценка {{movie.user_mark}}</div>
      </div>
      <div class="styles_raiting_container__margin styles_container__back styles_container__disp">
        <div class="styles_сontainer__props">
          <h3 class="styles_actors_title__margin styles_title_info__font_style styles_title__color">Trailer</h3>
          <div class="styles_trailerContainer__margin_align">
            <iframe width="560" height="315" v-bind:src=movie.trailer allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import User from "../components/user/user";
import Empty_star from "@/components/stars/Empty_star";
import Full_star from "@/components/stars/Full_star";
import Hovered_star from "@/components/stars/Hovered_star";

import api from './backend-api'

export default {
  name: "Content",
  components: {Hovered_star, Full_star, Empty_star},
  methods: {
    send_mark(mark){
      console.log('Отправлена оценка ' + mark)
      this.movie.user_mark = mark
    },
    over_star(star_index){
      this.actual_mark = star_index
    },
    out_star(){
      this.actual_mark = 0
    },
  },
  created() {
    api.getMovie(this.$route.params.id).then((response) => {
      this.movie = response.data
      let release_date = response.data.release.slice(0, 10).split('-')
      const monthNames = ["January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
      ];
      this.movie.year = release_date[0]
      this.movie.release = parseInt(release_date[2]) + " " + monthNames[parseInt(release_date[1])-1] + " " + release_date[0]
    })
  },
  data() {
  return{
      user: User,
      actual_mark: 0,
      empty_star: "url('/src/assets/Empty_star.png')",
      full_star: "url('/src/assets/Full_star.png')",
      hovered_star: "url('/src/assets/Hovered_star.png')",
      movie: {
        id: 0,
        name: '',
        poster: '',
        year: '',
        release: '',
        country: [],
        genre: [],
        director: [],
        writer: [],
        producer: [],
        operator: [],
        compositor: [],
        actor: [],
        budget: 0,
        box_office: 0,
        duration: '',
        synopsis: '',
        rating: 0.0,
        trailer: ''
      }
    }
  }
}
</script>