import Vue from "vue";
import Vuex from "vuex";
import axios from "axios"
import http from "../services/http-common.js"

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        userList: [],
        id: 0,
        name: "",
        title: "",
        content: "",
        pw: 0
    },
    mutations: {
        READ_INFO(state, payload) {
            state.userList = payload
        },
        READ_INFO_ONE(state, payload) {
            state.name = state.userList[payload].name
            state.title = state.userList[payload].title
            state.content = state.userList[payload].content
            state.pw = state.userList[payload].pw
        },
        ADD_INFO(state, payload) {
            state.name = payload.name
            state.title = payload.title
            state.content = payload.content
            state.pw = payload.pw
        },
        UPDATE_INFO(state, payload) {
            if (state.pw == payload.pw) {
                state.name = payload.name
                state.title = payload.title
                state.content = payload.content
            } else {
                alert("비밀번호가 다릅니다.")
            }
        }
    },
    actions: {
        readUser(context) {
            http
                .get("/board")
                .then(res => {
                    context.commit("READ_INFO", res.data)
                })
                .catch(error => {
                    console.log(error);
                });
        },
        readUserOne(context, payload) {
            http
                .get(`/board/${payload}`)
                .then(res => {
                    context.commit("READ_INFO", res.data)
                })
                .catch(error => {
                    console.log(error);
                });
        },
        addUser(context) {
            http
                .post("/board", {
                    b_name: context.state.name, b_title: context.state.title,
                    b_content: context.state.content, b_pw: context.state.pw
                })
                .then(res => {
                    context.commit("READ_INFO", res.data)
                })
                .catch(error => {
                    console.log(error);
                });
        },
        deleteUser(context, payload) {
            http
                .delete(`/board/${payload}`)
                .then(res => {
                    context.commit("READ_INFO", res.data)
                })
                .catch(error => {
                    console.log(error);
                });
        },
        updateUser(context, payload) {
            http
                .put("/board", {
                    b_id: `${payload}`, b_name: this.updateName, b_title: this.updateTitle,
                    b_content: this.updateContent, b_pw: this.updatePw
                })
                .then(res => {
                    context.commit("READ_INFO", res.data)
                })
                .catch(error => {
                    console.log(error);
                });
        }
    },
    getters: {
        getUser(state) {
            return state.userList;
        }
    }
});
