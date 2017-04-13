import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

const state = {
  pagesVisited: 1
};

const getters = {};
const actions = {};
const mutations = {
  increment (state) {
    state.pagesVisited += 1;
  }
};

const store = new Vuex.Store({
  state,
  getters,
  actions,
  mutations
});

export default store;
