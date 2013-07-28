package tddbc

/**
 * Created with IntelliJ IDEA.
 * User: youtarot
 * Date: 13/07/28
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
class SeaLion {
    // TODO よりふさわしい名前にRename
    String say(){
        def file = new File('./hoge.txt')
        if (!file.exists()) return "TODOないよー"

        def todoList = file.readLines()

        def todoString = ""
        todoList.each {
            if (!"TODOStart".equals(it) && !"TODOEnd".equals(it))
                todoString = todoString + it + "\n"
        }
        return todoString
    }

    String sayFirst() {
        return 'TODOないよー'
    }
}
