package tddbc

import org.junit.Ignore;
import spock.lang.Specification
import spock.lang.Unroll

class SampleSpec extends Specification {

    def "テキストがないときは「TODOないよー」という文字列を返す"() {

        given:
        def sut = new SeaLion()

        when:
        String actual = sut.say()

        then:
        actual == 'TODOないよー'

    }

    def "テキストがあって空っぽのときは「TODOないよー」という文字列を返す"() {

        given:
        def sut = new SeaLion()

        when:
        String actual = sut.say()

        then:
        actual == 'TODOないよー'

    }

    def "テキストがあってTODOが1つ登録されているときは「'卵買ってくる'」という文字列を返す"() {
        given:
        def sut = new SeaLion()

        when:
        File file = makeFile('卵買ってくる\n')

        then:
        sut.say() == '卵買ってくる\n'

        cleanup:
        file.delete()
    }

    def "テキストがあってTODOが1つ登録されているときは「'夜逃げする'」という文字列を返す"() {
        given:
        def sut = new SeaLion()

        when:
        File file = makeFile('夜逃げする\n')

        then:
        sut.say() == '夜逃げする\n'

        cleanup:
        file.delete()
    }

    def "テキストがあってTODOが2つ登録されているときは「'卵買ってくる'、'夜逃げする'」という文字列を返す"() {
        given:
        def sut = new SeaLion()

        when:
        File file = makeFile('卵買ってくる\n夜逃げする\n')

        then:
        sut.say() == '卵買ってくる\n夜逃げする\n'

        cleanup:
        file.delete()
    }

    private File makeFile(def item) {
        def file = new File('./hoge.txt')
        file << 'TODOStart\n'
        file << item
        file << 'TODOEnd\n'
        file
    }

    def "TODOが何も登録されていないとき、最初のTODOを取得しても、「TODOないよー」という文字列を返す"() {
        given:
        SeaLion sut = new SeaLion()

        when:
        def expected = sut.sayFirst()

        then:
        expected == 'TODOないよー'

    }

}
