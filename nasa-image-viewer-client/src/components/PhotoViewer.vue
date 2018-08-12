<template>
  <vue-img-loader :src="photoUrl"
    width="600"
    height="400"
    center-type="contain"
    background-color="lightgrey">
  </vue-img-loader>
  <!-- <img :src="photoUrl"> -->
</template>
<script>
  import VueImgLoader from 'vue-img-loader';
  import NasaImageApiService from '../services/NasaImageApiService';
  export default {
    components: {
      VueImgLoader
    },
    data () {
      return {
        loading: false,
      }
    },
    props: {
      currentPhoto: {
        required: true,
        type: Object
      }
    },
    computed: {
      photoUrl () {
        return NasaImageApiService.getPhotoUrl(this.currentPhoto);
      }
    }
  }
</script>
