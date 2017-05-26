<template>
  <div class="login-box">
    <form method="POST" class="login-form" v-on:submit="submitLogin">
      <div class="form-input">
        <label>Username:
          <input type="text" v-model="login.userName">
        </label>
      </div>
      <div class="form-input">
        <label>Password:
          <input type="password" v-model="login.password">
        </label>
      </div>
      <button type="submit">login</button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      login: {
        userName: '',
        password: ''
      }
    }
  },
  methods: {
    submitLogin (evt) {
      evt.preventDefault();

      this.$http[evt.target.method]('/api/login', this.login)
        .then(data => {
          console.log(data);
        })
        .catch(err => {
          console.error(err);
        });

      console.log(evt.target.method, JSON.stringify(this.login));
    }
  }
}
</script>

<style scoped>
</style>
