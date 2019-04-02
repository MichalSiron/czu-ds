import { ACCESS_TOKEN } from '../constants';
import axios from '../axios';

const request = (options) => {
    let headers = {};

    if(localStorage.getItem(ACCESS_TOKEN)) {
        // headers.append('Authorization', 'Bearer ' + localStorage.getItem(ACCESS_TOKEN));
        headers = {'Authorization': 'Bearer ' + localStorage.getItem(ACCESS_TOKEN)};
    }
    options = {
        ...options,
        headers
    };

    return axios(options);
        // .then(response => console.log(response))
        // .catch(err => console.log());
};

export function checkUsernameAvailability(username) {
    return request({
        url: '/user/checkUsernameAvailability?username=' + username,
        method: 'GET'
    });
}

export function checkEmailAvailability(email) {
    console.log(email);
    return request({
        url: '/user/checkEmailAvailability?email=' + email,
        method: 'GET'
    });
}

export function getAllDoctors() {
    return request({
        url: '/doctors',
        method: 'GET'
    });
}

export function getCurrentUser() {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    return request({
        url: '/user/me',
        method: 'GET'
    });
}

export function getValidatedDoctorsForProfile(username, validated) {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    return request({
        url: '/users/'+username+'/doctors?valid='+validated,
        method: 'GET'
    });
}

export function getUserProfile(username) {
    return request({
        url: '/users/' + username,
        method: 'GET'
    });
}

export function login(loginRequest) {
    return request({
        url: '/auth/signin',
        method: 'POST',
        data: loginRequest
    });
}

export function signup(signupRequest) {
    return request({
        url: '/auth/signup',
        method: 'POST',
        data: signupRequest
    })

}