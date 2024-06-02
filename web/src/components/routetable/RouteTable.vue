<template>
    <el-card class="box-card">
        <el-table ref="routeTable" :data="routes" style="width: 100%">
            <el-table-column type="index" width="50"> </el-table-column>
            <el-table-column property="formatDate" label="Маршрут" width="150">
            </el-table-column>
            <el-table-column
                property="operatingFullResource"
                label="Наработка полного технического ресурса двигателя, ч"
            >
            </el-table-column>
            <el-table-column
                property="length"
                label="Длина, км/миль"
                width="200"
            >
                <template slot-scope="scope">
                    <span
                        >{{ scope.row.length }} /
                        {{ distanceToMiles(scope.row.length).toFixed(2) }}
                    </span>
                </template>
            </el-table-column>
        </el-table>
    </el-card>
</template>

<script src="./RouteTable.ts" lang="ts"></script>

<style lang="scss" scoped>
.box-card {
    width: 38%;
}
::v-deep {
    .el-table__header-wrapper th {
        font-size: 13px;
    }
    .el-table .cell {
        word-break: break-word;
    }
}
</style>
