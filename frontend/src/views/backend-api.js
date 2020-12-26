import axios from 'axios'
import qs from 'querystring'

const AXIOS = axios.create({
    baseURL: 'http://localhost:8082/',
});

export default {
    getMovie(movieId){
        return AXIOS.get('/movie/' + movieId);
    },

    getMoviePoster(movieId){
        return AXIOS.get('/movie/' + movieId + '/img')
    },

    getMovieWithHigherRating(){
        return AXIOS.get('/');
    },

    getRandomMovieId(){
        return AXIOS.get('/random')
    },

    ajaxUsernameNotExists(username){
        console.log('Sending')
        return AXIOS.post('auth/registration/ajax', {'username': username})
    },

    sendUserRegistrationData(username, password){
        return AXIOS.post('/auth/registration/', {'username': username, 'password': password})
    },

    authorizationUser(username, password){
        const authRequestBody = {
            'grant_type': 'password',
            username: username,
            password: password
        }
        return AXIOS.post('/auth/request', qs.stringify(authRequestBody),
            {headers: {
                    Authorization: 'Basic Y2luZW1hLXNlYXJjaC1jbGllbnQ6Y2xpZW50MTIz',
                    'Content-Type': 'application/x-www-form-urlencoded'
                }})
    },

    getUser(userId){
        return AXIOS.get('/user/' + userId);
    },

    getUserIdByUsername(username){
        return AXIOS.get('/user/current?username=' + username);
    },

    putMovieRatingByUser(movie_id, rating, access_token){
        console.log(rating)
        return AXIOS.put('/user/movie/' + movie_id,{rating: rating},
            {headers: {Authorization: 'Bearer '+ access_token}})
    },

    getUserMovieRating(movie_id, access_token){
        return AXIOS.get('/user/movie/' + movie_id + '/current_user',
            {headers: {Authorization: 'Bearer ' + access_token}})
    },

    getUserAvatar(user_id){
        return AXIOS.get('/user/' + user_id + '/avatar')
    },

    postUserAvatar(user_id, avatar){
        console.log(avatar)
        return AXIOS.post('/user/' + user_id + '/avatar', avatar, {headers: {
            'Content-Type': 'multipart/form-data'}})
    }
}