<template>
  <div id="register">
    <h3>Register</h3>
      <form method="POST" v-on:submit="submitRegister">
        <div>
          <label>Username
            <input type="text" v-model="register.username">
          </label>
        </div>
        <div>
          <label>Email
            <input type="text" v-model="register.email">
          </label>
        </div>
        <div>
          <label>Password
            <input type="password" v-model="register.password">
          </label>
        </div>
        <div>
          <label>Rewrite Password
            <input type="password" v-model="register.password2">
          </label>
        </div>
        <button type="submit">Register</button>
      </form>
  </div>
</template>

<script>
export default {
  name: 'register',
  data () {
    return {
      register: {
        username: '',
        email: '',
        password: '',
        password2: ''
      }
    }
  },
  methods: {
    validateForm (evt) {
      if (this.register.password !== this.register.password2) {
        alert('passwords do not match');
        return false;
      }
    },
    submitRegister (evt) {
      evt.preventDefault();
      if (!this.validateForm(evt)) {
        return;
      }
      this.$http.post('/api/',
    }
  }
}
</script>

<style scoped>
</style>
