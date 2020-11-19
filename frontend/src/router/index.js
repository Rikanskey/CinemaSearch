import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home'
import Content from "../views/Content";
import AuthReg from "../views/AuthReg";
import Profile from "../views/Profile";

Vue.use(Router)

const router = new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/film/:id',
            name: 'Content',
            component: Content
        },
        {
            path: '/auth',
            name: 'AuthReg',
            component: AuthReg
        },
        {
            path: '/profile/:id',
            name: 'Profile',
            component: Profile
        }
    ]
})

export default router