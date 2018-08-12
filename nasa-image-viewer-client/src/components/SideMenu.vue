<template>
  <el-aside width="220px">
    <img src="../assets/nasa_logo_bw.png">
    <el-menu class="el-menu-vertical"
      v-loading.fullscreen.lock="loading">
      <RoverList
        :rovers="rovers"
        :dates="dates"
      />
    </el-menu>
  </el-aside>
</template>
<script>
  import NasaImageApiService from '../services/NasaImageApiService';
  import DateList from './DateList';
  import RoverList from './RoverList';
  import axios from 'axios';
  export default {
    components: {
      DateList,
      RoverList
    },
    data () {
      return {
        rovers: [],
        dates: [],
        loading: false,
      }
    },
    mounted () {
      this.getRoversAndDates();
    },
    methods: {
      getRoverList() {
        return NasaImageApiService.getRoverList().then(response => this.rovers = response.data.rovers);
      },
      getDateList() {
        return NasaImageApiService.getDateList().then(response => this.dates = response.data);
      },
      getRoversAndDates() {
        this.loading = true;
        return axios.all([
          this.getRoverList(),
          this.getDateList()
        ]).finally(() => this.loading = false);
      }
    }
  }
</script>
<style>
  .el-menu-vertical {
    text-align: left;
  }
</style>

