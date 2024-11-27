# 座席・予約管理システム
## 概要
2年ほど前に学校で、飲食チェーン店でよく見かける、座席・予約管理システムを作ったので、掲載します。<br>
※お店で使えるレベルではありません。<br>

<table>
  <tbody>
    <tr>
      <th scope="row"><b>背景</b></th>
      <td>
        ・アルバイトで、何も考えずに座席を決められるシステムにしたいと思ったから<br>
        ・座席の掃除が終わったことをレジに伝えに行くのがめんどくさかったから<br>
      </td>
    </tr>
    <tr>
      <th scope="row"><b>目的</b></th>
      <td>
        ・身近で不便に感じたことを解決する<br>
        ・ソフトウェア開発の難しさを知る<br>
      </td>
    </tr>
    <tr>
      <th scope="row"><b>目標</b></th>
      <td>
        ・席を提案してくれるようにする<br>
        ・掃除が完了したことを簡単に知らせられるようにする<br>
        ・既存の機能も実装する（座席状況の表示、予約、取り消し）<br>
      </td>
    </tr>
    <tr>
      <th scope="row"><b>開発人数</b></th>
      <td>3人</td>
    </tr>
    <tr>
      <th scope="row"><b>担当区分</b></th>
      <td>
        ・設計全般<br>
        ・サーバ・クライアント通信<br>
        ・外部のプログラミング<br>
        ・結合のプログラミング<br>
      </td>
    </tr>
  </tbody>
</table>

## 流れ
### <b>【全体像】</b>
以下のように、<b>「レジ側の画面」,「座席側の画面」,「サーバ」</b>の3つのシステムを制作しました。<br><br>
レジにおいてある画面を触ることで、サーバとやり取りをし、座席側の画面も動かせるといったものになっています。ただ、掃除完了時だけは座席側からの操作になっています。<br><br><br>

<b>システムの構造とシステム間のやり取り</b><br><br>
<img src="https://github.com/user-attachments/assets/1b3acab6-0898-440c-8cac-6e79297a756f" alt="全体像" title="全体像" width=60%>

<br>
<br>
シーケンス図では、お客様がご来店されたとき、予約をされたとき、食べ始め、食べ終わりの際のやり取りを示しています。<br><br>
お客様が予約をされていても、されていなくても基本的に流れは同じで、人数と来店時間を入力し、提案された内容から席を選ぶようにします。その後、リストが送られてくるので、そこから選ぶようにします。<br><br><br>
<b>シーケンス図</b><br><br>
<img src="https://github.com/user-attachments/assets/7c740884-8337-4b3d-8c7e-83e47e801375" alt="シーケンス図" title="シーケンス図" width=60%><br><br><br>

### <b>【デモ】</b>
ここでは、レジ側の画面の立ち上げ、席の確保、食べ始めた時の動作、食べ終わった後の動作、掃除完了の動作を流れで説明していきます。<br>

<b>〇レジ画面の立ち上げ</b><br>
プログラムをスタートすると、まず以下のような画面が出てきます。この画面は、レジ側の画面でお店のIDを入力する画面になります。今回は「1」と入力すると、次の画面に遷移します。<br><br>
 <img src="https://github.com/user-attachments/assets/dccffcbf-e6e0-4df8-94b2-75452e158889"><br><br><br>
以下の写真は、営業時間中に表示されるレジ側の画面になります。<br>
画面のそれぞれの役割を説明します。<br>
<b>画面左上：</b>店内の配置を表しており、各席には「席番（許容人数）」が表示されています。<br>
<b>画面右：</b>お客様の情報を入力でき、サーバに座席・開始時間の提案要求を出すことができます。<br>
<b>画面左下：</b>予約されたお客様の情報表示や、予約キャンセルなどができます。<br><br>
<img src="https://github.com/user-attachments/assets/b4c300e6-681f-4a20-9851-600ab60f2e9a" width=60%><br><br><br>

<b>〇席の確保</b><br>
実際に「人数（8人）」と「時間（18:00）」を入力して提案要求を出してみます。「完了」を押すと、実行できます。<br><br>
<img src="https://github.com/user-attachments/assets/5dd67d40-5cb4-4fb5-844a-49b1afc3335f" width=60%><br><br>

「完了」を押すと以下のような画面が出てきます。ここでは、サーバから送られてきた提案が表示されます。<br><br>
先ほど、人数を「8」、時間を「18:00」と入力したので、8人座席の「9」と「10」が提案として、出されています。選択肢を一つ選択（今回は「10」を選択）して、下の空欄に名前を入力（今回は「SAMPLE」と入力）し、「完了」を押すと、座席の確保が確定します。<br><br>
<img src="https://github.com/user-attachments/assets/143a18cb-1fa6-4554-85c1-2c1dcc5fd329" width=80%><br><br>

座席が確保できると、先ほどのレジ画面の左下の部分でリストに追加されていることが分かります。<br><br>
<img src="https://github.com/user-attachments/assets/87145832-6ef8-4a3e-ac64-ce6c9b659fd4" width=60%><br><br>

<b>〇食べ始め（お客様がご来店）</b><br>
お客様がご来店された時には、先ほどのリストで該当するものを選択し、「完了」を押すと、先ほどのレジ画面の座席横に「✔」が入り、現在使用中であることが示されます。<br><br>
<img src="https://github.com/user-attachments/assets/796dcb10-e708-4cb0-9c78-a27b4a647582" width=60%><br><br>

座席が使用状態になると、その座席においてある画面が「いらっしゃいませ（↓の1枚目の画像）」から注文画面（↓の2枚目の画像）に切り替わります。<br><br>
<img src="https://github.com/user-attachments/assets/da449e99-09e7-4ad2-b940-d7d13a4a5a01" width=30%><br><br>
<img src="https://github.com/user-attachments/assets/17e3f37c-2d33-4c58-a06f-2a34ade99dc4" width=60%><br><br>

<b>〇食べ終わり</b><br>
お客様が食べ終わり、「会計」を押すと、以下のように「ありがとうございます！」と表示されます。<br><br>
<img src="https://github.com/user-attachments/assets/22ae1560-42cb-4b95-9e90-7fa7b5fcb016" width=30%><br><br>

<b>〇掃除完了</b><br>
そして、その画面を消し、パスワードを（今回は「123」）入力すると、座席側では「いらっしゃいませ」の画面に再び切り替わります。<br>
また、それと同時に、レジ側の画面には以下のように掃除完了表示が出てきます。<br><br>
<img src="https://github.com/user-attachments/assets/23d04b1b-96b8-43a0-94db-c67ef03bbad6" width=30%><br><br>

ここまでが、大まかな流れです。これ以外にも入力間違い表示や、予約取り消し機能などを実装しました。<br>

## 開発環境・必要なライブラリ
<table>
  <tbody>
    <tr>
      <th scope="row"><b>実行環境</b></th>
      <td>
        Apache NetBeans IDE 12.6<br>
      </td>
    </tr>
    <tr>
      <th scope="row"><b>Javaのバージョン</b></th>
      <td>
        jdk-17.0.2<br>
      </td>
    </tr>
    <tr>
      <th scope="row"><b>必要なライブラリ</b></th>
      <td>
        ・jackson-annotations-2.15.2.jar<br>
        ・jackson-core-2.15.2.jar<br>
        ・jackson-databind-2.15.2.jar<br>
        ・javax.websocket-api-1.1.jar<br>
        URL:https://mvnrepository.com/artifact/com.fasterxml.jackson.core<br>
      </td>
    </tr>
  </tbody>
</table>


## 実行の仕方

## さいごに
<b>【工夫点・できたこと】</b><br>
・席の提案、掃除完了の知らせの機能を実装できた。<br>
・店員が画面を見た時に一番にほしい情報（席の使用状況など）をわかりやすいように提示した。<br>
・いたるところで、入力間違いに対するエラー表示し、動作が止まらないようにした。<br>
・JSONという方式でデータを送り、その内容をもとに、どのシステムがどのシステムに命令を出しているのか、わかるようにした。<br><br>

<b>【反省点】</b><br>
・知識不足でDBを使えなかったこと。<br>
・設計の段階で、どのデータをどの段階で渡すのかをしっかり決めれなかったこと。<br>
・座席用のシステム自体もサーバにつなげてしまったことで、複数店舗想定で動かしたときにエラーが起きてしまうこと。<br>
・便利にしようと考えすぎたあまり、ボタンが増えてしまい、結果として使いづらくなってしまったこと。<br>
・プログラムの構成をしっかり考えていなかったことで、見返したときにどこで何を動かしているのかわからなかったこと。<br>
・仕様を増やしすぎたあまり、どれも中途半端になってしまったこと。<br><br>

<b>【今後の展望】</b><br>
・DBを活用して、もっと有効的なデータ管理を行っていきたい。<br>
・WEBサイト上で使えるようにしたい。<br>
・UML図などを使ってしっかり設計を行うこと。<br>
・プログラムにおいても、書き出す前に構成をしっかりと考えること。<br>

## その他

## 注意事項
このリポジトリは、企業向けに作成されたポートフォリオです。内容の無断転載、画像や動画の無断使用は固くお断りいたします。

- **利用範囲**: このリポジトリは、URLを知っている方に公開されています。ただし、内容を許可なく第三者と共有したり、商用利用することは禁止されています。
- **著作権**: このリポジトリ内のコード、画像、動画、その他のコンテンツの著作権は全て作成者に帰属します。

よろしくお願いいたします。