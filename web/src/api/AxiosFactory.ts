import axios, {
    AxiosInstance,
    CancelToken,
    CancelTokenSource,
    Canceler,
} from 'axios';
import qs from 'qs';

class AxiosFactory {
    public readonly axiosInstance: AxiosInstance;

    public constructor() {
        this.axiosInstance = axios.create({
            // eslint-disable-next-line @typescript-eslint/no-explicit-any
            paramsSerializer: (params: any): string => {
                return qs.stringify(params, { arrayFormat: 'repeat' });
            },
        });
    }

    /**
     * Создание статического дефолтного токена из axios
     * @returns {any}
     */
    public createCancelTokenSource(): CancelTokenSource {
        return axios.CancelToken.source();
    }

    /**
     * Создание прокаченного токена
     * @returns {axios.CancelToken}
     */
    public createCancelToken(): CancelToken {
        const cancelToken = new axios.CancelToken(
            // eslint-disable-next-line @typescript-eslint/no-unused-vars
            (canceler: Canceler): void => {}
        );
        cancelToken.reason = new axios.Cancel('отмена запроса');
        return cancelToken;
    }

    /**
     * Проверка ощибки запроса на отменену для catch
     * @param request - запрос
     * @returns {boolean}
     */
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    public isCancel(request: any): boolean {
        return axios.isCancel(request);
    }
}

export const axiosFactory = new AxiosFactory();
