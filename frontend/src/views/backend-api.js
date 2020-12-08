import axios from 'axios'

const AXIOS = axios.create({
    baseURL: 'http://localhost:8082/',
    timeout: 1000
});

export default {
    getMovie(movieId){
        return AXIOS.get('/movie/' + movieId);
    },

    getMovieWithHigherRating(){
        return AXIOS.get('/');
    },

    getRandomMovieId(){
        return AXIOS.get('/random')
    }
}