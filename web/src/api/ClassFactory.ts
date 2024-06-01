import { plainToClass, classToPlain } from 'class-transformer';
import { ClassType } from 'class-transformer/ClassTransformer';
import { AxiosResponse } from 'axios';
/**
 * Валидатор
 * @param data
 */
function validate<V>(data: V[]) {
    if (typeof data === 'string') {
        // eslint-disable-next-line no-console
        console.error(
            'Аргумент data не должна быть строковым типом. Вероятно контроллер не использует Response.buildOk.' +
                ' Для трансформации в класс требуется выполнить JSON.parse(response.data)'
        );
    }
}

/**
 * Трансформирует данные с сервера в объекты определённого класса
 * @param clazz класс
 * @param data список объектов
 * @returns {any}
 */
export function dataToArrayClass<T, V>(clazz: ClassType<T>, data: V[]): T[] {
    const result = plainToClass(clazz, data);
    if (Array.isArray(result)) {
        return result;
    }
    return [result];
}

/**
 * Трансформирует данные с сервера в объект определённого класса
 * @param clazz класс
 * @param data объект
 * @returns {any}
 */
export function dataToClass<T, V>(clazz: ClassType<T>, data: V[]): T {
    validate(data);

    const result = plainToClass(clazz, data);
    if (Array.isArray(result)) {
        return result[0];
    }
    return result;
}

/**
 * Трансформирует данные с сервера в объект определённого класса
 * @param clazz класс
 * @param response ответ сервера
 * @returns {any}
 */
export function responseToClass<T, V>(
    clazz: ClassType<T>,
    response: AxiosResponse
): T {
    validate(response.data);

    const result = plainToClass(clazz, response.data);
    if (Array.isArray(result)) {
        return result[0];
    }
    return result;
}

/**
 * Трансформирует данные в json
 * @param data список объектов
 * @returns {any}
 */
export function dataToPlain<T>(data: T[] | T): Record<string, any> {
    return classToPlain(data);
}
