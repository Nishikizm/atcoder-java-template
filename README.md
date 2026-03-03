# atcoder-java-template

競技プログラミング（AtCoder）で使用するための高速リーダを作成し、<br>
従来のScannerとの読み取り速度の比較を行った。

## 概要

JavaでAtCoderのコンテストに参加する中で、<br>
JavaのScannerはC++などの他言語と比べると処理速度が遅いと知った。<br>
Scannerが遅い理由は主に内部で正規表現の解析を行っている点であるため、<br>
正規表現解析を行わないBufferedReader(+ StringTokenizer)を用いたリーダを自作した。<br>

また、実際の性能差を検証するため、ベンチマークテストを行った。

## テスト結果

空白/改行で区切った100万件のint、long、doubleが記載されたファイルを読み込み、<br>
ScannerとBufferedReaderでそれぞれ実行速度を測定した。<br>
各5回ずつ測定を行い、平均値は以下のようになった。

|  | Scanner | BufferedReader |
| ------------ | :------------: | :------------: |
| **int** | 1.2 | 0.0 |
| **long** | 0.0 | 0.0 |
| **double** | 2.4 | 0.0 |

※単位はms


## ファイル

- **Main.java**: AtCoderのコンテストで使用できるテンプレート
- **benchmark-data/sample/***: テストデータのサンプル<br>
<br>
    *src/main/java/io/github/nishikizm/atcoderjavatemplate/*
- **benchmark/IOBenchmark.java**: ベンチマークテスト
- **io/ScannerIO.java**: Scannerによるデータ読み取りの実装（テスト用）
- **io/BuffredReaderIO.java**: BufferedReaderによるデータ読み取りの実装（テスト用）
- **tools/***: ベンチマークテストのテストデータ作成用

## 使用技術

- Java 17
- Maven

## 補足

- BigDecimalを使った金額の取り扱いの練習のため、テーブルに *balance* を含めた。
- Docker Composeを用いたコンテナ環境での利用を想定してDB接続情報は *.env* に記述し、dotenv-javaを利用して読み込んでいる。

## 関連

AtCoderアカウント（ https://atcoder.jp/users/IwsS ）