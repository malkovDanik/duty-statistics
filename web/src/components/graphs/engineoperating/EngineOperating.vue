<template>
    <div class="chart-container">
        <span style="font-size: 13px; color: #303133;"
            >Полная наработка двигателя с начала эксплуатации судна</span
        >
        <div :id="containerId" class="chart"></div>
    </div>
</template>

<script lang="ts" src="./EngineOperating.ts" />

<style lang="scss" scoped>
.chart-container {
    height: 100%;
    width: 100%;
    display: block;
}
.chart {
    height: 100%;
    width: 100%;
    ::v-deep {
        .anychart-credits {
            display: none;
        }
    }
}
</style>
