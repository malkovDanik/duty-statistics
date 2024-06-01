import { Component, Vue } from 'vue-property-decorator';
import DutyStatistics from '@/components/DutyStatistics';

@Component({ components: { DutyStatistics } })
export default class App extends Vue {
    private header: string = '';
}
