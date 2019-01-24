package com.dh.base;

/**
 * 增补字符集被UTF-16表示时，使用四个字节，即两个16位，前16位为高代理项（范围为U+D800-U+DBFF），后16位为低代理项（范围为U+DC00-U+DFFF）
 * Java内部使用两个char来表示一个增补字符，分别表示其高代理项与低代理项，并提供了转换的方法。
 */
public class CharacterTest {
    public static void main(String[] args) {
        Character c = new Character('a');
        String s = Character.toString('a');
        System.out.println(c.toString().equals(s));
        char cc = c.charValue();
        // 校验给定的整数值是否是有效的代码点（Unicode编号U+000000-U+10FFFF）
        System.out.println(Character.isValidCodePoint(1211212));
        // 校验给定的整数值是否是基本字符集对应的代码点（Unicode编号U+0000-U+FFFF）
        System.out.println(Character.isBmpCodePoint(12345));
        // 校验给定的整数值是否是增补字符集对应的代码点（Unicode编号U+10000-U+10FFFF）
        System.out.println(Character.isSupplementaryCodePoint(112));
        // 校验给定的字符是否是增补字符的高代理项（范围U+D800-U+DBFF）
        System.out.println(Character.isHighSurrogate('1'));
        // 校验给定的字符是否是增补字符的低代理项（范围U+DC00-U+DFFF）
        System.out.println(Character.isLowSurrogate('1'));
        // 校验给定的字符是否是增补字符的代理项（范围U+D800-U+DFFF）
        System.out.println(Character.isSurrogate('1'));
        // 校验给定的字符对是否是增补字符的高代理项与低代理项（范围U+D800-U+DBFF和U+DC00-U+DFFF）
        System.out.println(Character.isSurrogatePair('1','2'));
        // 返回给定整数值代表的代码点包含的char数量，如果是基本字符集范围返回1，如果是增补字符集范围返回2
        System.out.println(Character.charCount(123123));
        // 将给定的高低代理项对转换为Unicode代码点
        System.out.println(Character.toCodePoint('1','2'));
        // 返回指定字符序列中给定位置的字符的Unicode代码点,如果发现指定位置的字符的代码点位于高代理位（U+D800-U+DBFF）则，检查其下一个字符是否是低代理位，如果是，则将二者组合解析为增补字符，将其代码点放回
        System.out.println(Character.codePointAt("123321",0));
        // 同上，只是将字符序列改为字符数组
        char[] ccc = {'1','2','3','4'};
        System.out.println(Character.codePointAt(ccc, 2));
        // 基本同上，只是添加了一个limit限制，可用的下标必须小于limit,这样一来即便指定位为高代理项，一旦低代理项的下标超过了limit,那么也无法返回增补字符的代码点了，只会返回指定那一位的代码点（范围会在U+D800-U+DBFF）
        System.out.println(Character.codePointAt(ccc,2,3));
        System.out.println(Character.codePointBefore("123321",2));
        System.out.println(Character.codePointBefore(ccc,2));
        System.out.println(Character.codePointBefore(ccc,2,0));
        // 返回给定代码点指定的字符的高代理项的char表示，如果给定的不是增补字符的代码点，那么会返回一个给指定的字符
        System.out.println(Character.highSurrogate(123456));
        // 同上
        System.out.println(Character.lowSurrogate(123456));
        // 将给定的Unicode代码点转换为的UTF-16表示法，使用char数组接收，如果是BMP，则接收到数组的指定下标位，并返回1；如果为增补字符则接收到指定的下标和下标+1位，并放回2
        System.out.println(Character.toChars(123321,ccc,1));
        // 将给定的Unicode代码点转换为UTF-16表示法，将其保存在一个char数组中返回，如果是BMP,数组只有1位，否则，数组拥有2位
        System.out.println(Character.toChars(123321));
        // 统计给定字符序列seq中从开始下标到结束下标范围内的Unicode代码点数量，即实际字符数量，每个不成对的代理项，均看成为一个代码点
        System.out.println(Character.codePointCount("123321123321",1,2));
        // 同上，将字符序列改为字符数组
        System.out.println(Character.codePointCount(ccc,1,2));
        //
    }
}
