
### Swagger常用的注解
以下是Swagger常用的注解：
@Api: 用于控制整个类的Swagger文档，描述接口类的基本信息和可见范围。
@ApiOperation: 用于描述单个接口的信息，包括接口名称、接口方法、接口说明等。
@ApiImplicitParam: 描述单个入参信息，包括参数名称、参数类型、参数说明、是否必填等信息。
@ApiImplicitParams: 用于描述多个入参信息，可以包含多个@ApiImplicitParam注解。
@ApiModel: 用于描述Java Bean类，包括Java Bean类的基本信息和可见范围。
@ApiModelProperty: 描述Java Bean类中的属性信息，包括属性名称、属性类型、属性说明等。
@ApiResponse: 描述接口返回结果的信息，包括返回结果的数据类型、返回结果的说明等。
@ApiResponses: 用于描述多个返回结果的信息，可以包含多个@ApiResponse注解