<template>
  <div>
    <el-table
      :data="tableData.photos"
      empty-text="No Data to Display"
      v-loading="loading">
      <el-table-column
        prop="earth_date"
        label="Date"
        width="120">
      </el-table-column>
      <el-table-column
        prop="sol"
        label="Sol"
        width="100">
      </el-table-column>
      <el-table-column
        prop="rover.name"
        label="Rover"
        width="120">
      </el-table-column>
      <el-table-column
        prop="camera.full_name"
        label="Camera">
      </el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button
            @click.native.prevent="handleClick(scope)"
            type="text"
            size="small">View Photo</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      width="640px"
      :visible.sync="dialogPhotoVisible">
      <PhotoViewer :currentPhoto="currentPhoto"/>
    </el-dialog>
  </div>
</template>
<script>
  import NasaImageApiService from '../services/NasaImageApiService';
  import PhotoViewer from './PhotoViewer';
  import { EventBus } from '../services/EventBus';
  export default {
    components: {
      PhotoViewer
    },
    data() {
      return {
        tableData: {
          photos: []
        },
        loading: false,
        dialogPhotoVisible: false,
        currentPhoto: {},
      }
    },
    mounted() {
      EventBus.$on('date-clicked', roverInfo => {
        this.getPhotoList(roverInfo.name, roverInfo.date);
      });
    },
    beforeDestroy() {
      console.log('Turning Off EventBus');
      EventBus.$off();
    },
    methods: {
      getPhotoList(roverName, date) {
        this.loading = true;
        return NasaImageApiService.getPhotoList(roverName, date)
          .then(response => this.tableData = response.data)
          .finally(() => this.loading = false);
      },
      handleClick(scope) {
        this.currentPhoto = scope.row;
        this.dialogPhotoVisible = true;
      }
    }
  }
</script>
