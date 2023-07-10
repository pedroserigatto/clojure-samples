(defproject clojure-samples "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/pedroserigatto/clojure-samples"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}

  :plugins [[com.github.clojure-lsp/lein-clojure-lsp "1.3.24"]]

  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/test.check "1.1.1"]]

  :main ^:skip-aot clojure-samples.core

  :target-path "target/%s"

  :profiles {:uberjar {:aot      :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}}

  :aliases {"diagnostics"  ["clojure-lsp" "diagnostics"]
            "format"       ["clojure-lsp" "format" "--dry"]
            "format-fix"   ["clojure-lsp" "format"]
            "clean-ns"     ["clojure-lsp" "clean-ns" "--dry"]
            "clean-ns-fix" ["clojure-lsp" "clean-ns"]
            "lint"         ["do" ["diagnostics"] ["format"] ["clean-ns"]]
            "lint-fix"     ["do" ["format-fix"] ["clean-ns-fix"]]})
