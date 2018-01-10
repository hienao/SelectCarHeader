# SelectCarHeader

SelectCarHeader是一个选择车牌照开头省份的控件
[![](https://jitpack.io/v/shiwentao666/SelectCarHeader.svg)](https://jitpack.io/#shiwentao666/SelectCarHeader)  [![Build status](https://ci.appveyor.com/api/projects/status/ewutryrubo5i23yi?svg=true)](https://ci.appveyor.com/project/shiwentao666/selectcarheader)
![](gif/carheader.png) 
#### 引入方式

1. 在项目目录中的`build.gradle`文件中做如下修改：

   ```groovy
   allprojects {
   	repositories {
   		...
   		maven { url 'https://jitpack.io' }
   	}
   }

   ```

2. 添加依赖：

   ```groovy
   dependencies {
           compile 'com.github.shiwentao666:SelectCarHeader:0.2.2'
   }

   ```

3. 可设置的属性：

   定制化方法：

   ```xml
   <win.swt6.selectcarlib.SelectCharHeaderView
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:background="#D0D4DA"			         //区域背景
       app:column_num="10"								//每行item的数量
       app:cell_background="@color/colorAccent"		//每个候选项的背景色
       app:cell_height="15dp"							//每个item的高度
       app:cell_text_size="16sp"						//每个候选项中的文本大小
       app:cell_text_color="@color/red"				//每个候选项中的文本颜色
       app:cell_padding_horizontal="1dp"				//每个候选项横向内边距
       app:cell_padding_vertical="1dp"					//每个候选项垂直内边距
       app:cell_radius="1dp"							//每个候选项圆角大小
       app:shrink_background="@color/gray"				//收缩按钮背景色
       app:src_text="京,津,渝,沪,冀,晋,辽,吉,黑,苏,浙,皖,闽,赣,鲁,豫,鄂,湘,粤,琼,川,贵,云,陕,甘,青,蒙,桂,宁,新,藏,使,领,警,学,港,澳"				//要显示的文本数据
                                               />
   ```

   快捷使用：

    ```java
    SelectCarPopWindow.getInstance().showSelectCarPopWindow(MainActivity.this, new OnItemClickListener() {
                       @Override
                       public void selectString(String s) {
                           mTextView.setText(s);
                           SelectCarPopWindow.getInstance().dismissSelectCarPopWindow();
                       }
                   }, new OnShrinkButtonClickListener() {
                       @Override
                       public void click() {
                           SelectCarPopWindow.getInstance().dismissSelectCarPopWindow();
                       }
                   },mLayout);
    ```

